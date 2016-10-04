(function(global){
	var app = {};
	
	app.Book = Backbone.Model.extend({
		defaults: {
			coverImage:     "img/placeholder.png",
			title:          "No title",
			author:         "Unknown",
			releaseDate:    "Unknown",
			keywords:       "None"
		}
	});

	app.Library = Backbone.Collection.extend({
		model: app.Book
	});
	
	app.BookView = Backbone.View.extend({
		tagName: 'div',
		className: 'bookContainer',
		template: _.template($('#bookTemplate').html()),
		events: {
			'click .btn': 'deleteBook'
		},
		deleteBook: function(){
			alert("delete!");
			this.model.destroy();
			this.remove();
		},
		render: function(){
			this.$el.html(this.template(this.model.toJSON()));
			return this;
		}
	});
	
	app.LibraryView = Backbone.View.extend({
		el: '#books',
		events: {
			'click #add':'addBook'
		},
		initialize: function(initialBooks){
			this.collection = new app.Library(initialBooks);
			this.render();
			this.listenTo(this.collection, 'add', this.renderBook);
		},
		render: function() {
			this.collection.each(function (item) {
				this.renderBook( item );
			}, this);
		},
		renderBook: function(item){
			var bookView = new app.BookView({model: item});
			this.$el.append( bookView.render().el );
		},
		addBook: function(e) {
			e.preventDefault();
			var formData = {};
			$('#addBook div').children('input').each(function(i, el) {
				if ($(el).val() !== '') formData[el.id] = $(el).val();
			});
			this.collection.add(new app.Book(formData));
		}
	});
	
    app.libraryView = new app.LibraryView([]);
    // export application to global.
	global.booklib = app;
})(this);