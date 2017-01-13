@Inject IEventBroker broker;

...
// asynchronously
// sending code is not blocked until the event has been delivered
broker.post(MyEventConstants.TOPIC_TODO_NEW, todo);

//synchronously sending a todo
//the calling code is blocked until delivery

broker.send(MyEventConstants.TOPIC_TODO_NEW, newTodo);