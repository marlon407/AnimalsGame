package animals

class Animal {

	String name
	Question question

	static belongsTo = [Question];

    static constraints = {
    	name nullable:true
    	question nullable:true
    }
}
