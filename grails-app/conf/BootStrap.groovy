class BootStrap {

	def animalService

    def init = { servletContext ->
    	log.info("bootstrap")
    	animalService.bootstrapApp()
    }
    def destroy = {
    }
}
