class BootStrap {

	def gameService

    def init = { servletContext ->
    	log.info("bootstrap")
    	gameService.bootstrapApp()
    }
    def destroy = {
    }
}
