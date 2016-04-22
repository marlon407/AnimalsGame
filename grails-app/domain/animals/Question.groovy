package animals

class Question {

	String question
	Question leftChild
	Question rightChild
	Question parent

    static constraints = {
    	question nullable:true
    	leftChild nullable:true
    	rightChild nullable:true
    	parent nullable:true
    }
}
