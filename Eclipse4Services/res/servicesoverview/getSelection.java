@Inject
public void setTodo(@Optional 
		@Named(IServiceConstants.ACTIVE_SELECTION) List<Todo> todos) {
	if(todos != null && !todos.isEmpty()) {
		// do something with the list of todos
	}
}
