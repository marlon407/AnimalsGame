import animals.Animal;
import animals.Question;

class GameService {
	def grailsApplication
	
	//Bootstrap app to an initial state
	def bootstrapApp(){
		if (Question.count() == 0) {
			Question root = new Question()
			root.question = "vive na água"
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

	//Clean Database data and go back to the initial state
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

	String getNextQuestion(Question nextQuestion){
		Animal animal = Animal.findByQuestion(nextQuestion)
        return "é um(a) " + animal.name
	}

	def addToRightSide(Question questionInstance, Animal oldAnimal, Question animalQuestion, Question parent, Animal animal){
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
	    animal.question = newLeft
	    animal.save flush:true
	}

	def addToLeftSide(Question questionInstance, Animal oldAnimal, Question animalQuestion, Question parent, Animal animal){
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
        animal.question = newLeft
        animal.save flush:true
	}
}




