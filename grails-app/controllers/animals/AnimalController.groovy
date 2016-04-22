package animals

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AnimalController {

    def gameService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Animal.list(params), model:[animalInstanceCount: Animal.count()]
    }

    def show(Animal animalInstance) {
        respond animalInstance
    }

    def create() {
        Question currentQuestion = Question.get(params.currentQuestion)
        respond new Animal(params), model:[currentQuestion: currentQuestion]
    }

    @Transactional
    def save(Animal animalInstance) {
        animalInstance.question = null
        if (animalInstance == null) {
            notFound()
            return
        }

        if (animalInstance.hasErrors()) {
            log.info(animalInstance.errors)
            respond animalInstance.errors, view:'create'
            return
        }

        animalInstance.save flush:true

        request.withFormat {
            form multipartForm {
                redirect action: 'create', controller: 'question', params: [currentQuestion: params.currentQuestion, animal: animalInstance.id]
            }
            '*' { 
                respond animalInstance, [status: CREATED]
             }
        }
    }

    @Transactional
    def clearAll(){
        //Restore database to the initial state
        gameService.cleanData()
    }

    def instructions(){}

    def rules(){}
}
