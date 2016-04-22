import animals.Animal;
import animals.Question;

class AnimalService {
	def grailsApplication
	
	def bootstrapApp(){
		if (Question.count() == 0) {
			Question root = new Question()
			root.question = "Vive na agua"
			root.save flush:true
			Question left = new Question()
			left.parent = root
			left.save flush:true
			Question right = new Question()
			right.parent = root
			right.save flush:true
			root.leftChild = left
			root.rightChild = right
			root.save flush:true
			Animal macaco = new Animal()
			macaco.name = "Macaco"
			macaco.question = right
			Animal tubarao = new Animal()
			tubarao.name = "Tubarão"
			tubarao.question = left
			macaco.save flush:true
			tubarao.save flush:true
		}
	}

	def cleanData(){
		Animal.executeUpdate('delete from Animal')
		Question.findAll().each{ question ->
			question.parent = null
			question.leftChild = null
			question.rightChild = null
			question.save flush:true
		}
		Question.executeUpdate('delete from Question')
		bootstrapApp()
	}
}
