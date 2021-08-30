@RestController
class HelloCli {

    @RequestMapping("/")
    String home(){
        return "hello world"
    }

}
