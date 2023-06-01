//import org.springframework.beans.factory.annotation.Autowired;
//
//@Controller
//@RestController
//@RequestMapping("/tasks")
//public class TaskController {
//    private final TaskRepository repository;
//
//    @Autowired
//    public TaskController(TaskRepository repository) {
//        this.repository = repository;
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.SUCCESSFUL)
//    fun CreateTasks(@RequestBody task: TaskDto): Int {
//        var task = repository.save(task);
//        return task.id;
//
//    }
//
//    @GetMapping("{id}")
//    @ResponseStatus(HttpStatus.OK)
//    fun getTask(@PathVariable id: Long): TaskDTO {
//
//        repository.findByIdOrNull(id) ?: throw ResponseStatusException(HttpStatus.NO_CONTENT)
//        // repository.findById(id)
//        //     .map { task -> TaskDTO(task.id ,task.title, task.description, task.status) }
//        //     .orElse(null)
//    }
//
//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    fun updateTask(@PathVariable id: Long, @RequestBody task: TaskDTO): TaskDTO {
//
//        if (!isStatusValid(task.status)){
//            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Available statuses are: CREATED, APPROVED, REJECTED, BLOCKED, DONE.")
//        }
//        return if (repository.existsById(id)) {
//            repository.save(task)
//        } else
//            throw ResponseStatusException(HttpStatus.NO_CONTENT)
//    }
//
//    fun isStatusValid(status: String): Boolean {
//        return (status.equals("CREATED") || status.equals("CREATED") || status.equals("APPROVED") || status.equals("REJECTED") || status.equals(
//                "BLOCKED") || status.equals("DONE"))
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    fun deleteTask(@PathVariable id: Long) {
//        if (repository.existsById(id))
//            repository.deleteById(id)
//        else
//            throw ResponseStatusException(HttpStatus.NO_CONTENT)
//
//    }
//
//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    fun getAllTasks(): List<TaskDto>{
//        return repository.findAll()
//    }
//
//}
