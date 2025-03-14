from django.contrib import admin
from .models import Genre, Translator, Rating, Book, BooksTranslators
# Register your models here.


class GenreAdmin(admin.ModelAdmin):
    list_display = ("name",)

    def has_add_permission(self, request, obj=None):
        if request.user.is_superuser:
            return True
        return False

    def has_delete_permission(self, request, obj=None):
        if request.user.is_superuser:
            return True
        return False


class RatingInline(admin.TabularInline):
    model = Rating
    extra = 1

    def has_delete_permission(self, request, obj=None):
        if obj and obj.user == request.user:
            return True
        return False


class BookAdmin(admin.ModelAdmin):
    list_filter = ("available",)
    list_display = ("title", "author")
    inlines = [RatingInline,]

    def save_model(self, request, obj, form, change):
        obj.user = request.user
        return super(BookAdmin, self).save_model(request, obj, form, change)

    def has_change_permission(self, request, obj=None):
        if obj and obj.user == request.user:
            return True
        return False

    def has_delete_permission(self, request, obj=None):
        if obj and obj.user == request.user:
            return True
        return False


admin.site.register(Book, BookAdmin)
admin.site.register(Genre, GenreAdmin)
admin.site.register(Translator)
admin.site.register(BooksTranslators)
