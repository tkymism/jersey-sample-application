(function(global){
	var load_gapi_client = function(){
		var root = 'http://' + window.location.host + "/_ah/api";
		gapi.client.load('books_api', 'v1', loadInitLibrary, root);
	};
	var loadInitLibrary = function(){
		gapi.client.books_api.getList().execute(function(resp){
			var books = resp.books;
			for (var i=0; i<books.length; i++)
				addBookToView(books[i]);
		});
	};
	var addBookToView = function(book_msg){
		booklib.libraryView.collection.add(
			new booklib.Book(book_msg));
	};
	// export initLibrary
	global.initLibrary = load_gapi_client;
})(this);