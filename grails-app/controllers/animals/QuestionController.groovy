package animals



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class QuestionController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        //Select root question to be the first one to ask
        respond Question.list(params), model:[questionInstance: Question.findAll("from Question where parent = null")[0]], view:'question'
    }

    def answer(){
        Question question = Question.get(params.question)
        Question nextQuestion
        //If selected yes 
        if(params.answer == "true"){
            //try to find the left child
            if(question.leftChild){
                nextQuestion  = question.leftChild
            }
            //if no left child, the animal was found
            else{
                redirect action: 'success'
                return  
            }
        }
        //If selected no
        else{
            //try to find the right child
            if(question.rightChild){
                nextQuestion  = question.rightChild
            }
            //if no right child, create new animal
            else{
                redirect action: 'create', controller: 'animal', params: [currentQuestion: question.id]
                return
            }
        }
        //After get the next question
        //Verify if it has a question
        //if not, get the animal linked to that question
        if(nextQuestion.question == null || nextQuestion.question == ""){
            Animal animal = Animal.findByQuestion(nextQuestion)
            nextQuestion = animal.question
            nextQuestion.question = "é um(a) " + animal.name
        }
        //Return to the question asking the new one
        respond Question.list(params), model:[questionInstance: nextQuestion], view:'question'
    }

    def show(Question questionInstance) {
        respond questionInstance
    }

    def success(){

    }

    def create() {
        Question currentQuestion = Question.get(params.currentQuestion)
        Animal oldAnimal
        //find the animal linked to the parent question, in order to replace the leafs
        if(currentQuestion == currentQuestion.parent.rightChild){
            oldAnimal = Animal.findByQuestion(currentQuestion.parent.rightChild)
        }
        else{
            oldAnimal = Animal.findByQuestion(currentQuestion.parent.leftChild)
        }
        respond new Question(params), model:[parentQuestion: currentQuestion.parent, animal: Animal.get(params.animal), oldAnimal: oldAnimal]
    }

    @Transactional
    def save(Question questionInstance) {
        if (questionInstance == null) {
            notFound()
            return
        }

        if (questionInstance.hasErrors()) {
            respond questionInstance.errors, view:'create'
            return
        }
        Animal oldAnimal = Animal.get(params.oldAnimal)
        Question animalQuestion = oldAnimal.question
        Question parent = Question.get(params.parentQuestion)
        //set the parent to the new question
        questionInstance.parent = parent
        questionInstance.save flush:true
        //Decide to replace the right or the left child
        if(parent.rightChild == animalQuestion){
            Question oldRight = parent.rightChild
            //Replace parent's right child by the new question
            parent.rightChild = questionInstance
            parent.save flush:true
            //Old right child gets new parent
            oldRight.parent = questionInstance
            oldRight.save flush:true
            //new question's right child is set by oldRight
            questionInstance.rightChild = oldRight
            Question newLeft = new Question()
            //Set a new left child to the new question
            newLeft.parent = questionInstance
            newLeft.save flush:true
            questionInstance.leftChild = newLeft
            questionInstance.save flush:true
            //Link animal's question to the new question
            Animal animal = Animal.get(params.animal)
            animal.question = newLeft
            animal.save flush:true
        }
        else{
            Question oldLeft = parent.leftChild
            //Replace parent's left child by the new question
            parent.leftChild = questionInstance
            parent.save flush:true
            //Old left child gets new parent
            oldLeft.parent = questionInstance
            oldLeft.save flush:true
            //new question's right child is set by oldLeft
            questionInstance.rightChild = oldLeft
            Question newLeft = new Question()
            //Set a new left child to the new question
            newLeft.parent = questionInstance
            newLeft.save flush:true
            questionInstance.leftChild = newLeft
            questionInstance.save flush:true
            //Link animal's question to the new question
            Animal animal = Animal.get(params.animal)
            animal.question = newLeft
            animal.save flush:true
        }

        request.withFormat {
            form multipartForm {
                redirect(url:'/')
            }
            '*' { respond questionInstance, [status: CREATED] }
        }
    }
}
