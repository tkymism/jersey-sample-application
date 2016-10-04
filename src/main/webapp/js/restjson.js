(function(global){
	var loadInitLibrary = function(){
		$.getJSON("/rest/books/", function(data){
			for (var i=0; i<data.length; i++){
				var title = data[i].title;
				addBookToView(data[i]);
			}
		});
	};
	var addBookToView = function(book_msg){
		booklib.libraryView.collection.add(
			new booklib.Book(book_msg));
	};
	global.initLibrary = loadInitLibrary;
})(this);