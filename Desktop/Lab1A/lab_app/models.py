from django.contrib.auth.models import User
from django.db import models

# Create your models here.


#Жанровите се дефинираат со име и опис, при што нивно додавање и бришење е дозволено само за суперкорисници.
class Genre(models.Model):
    name = models.CharField(max_length=100)
    desc = models.CharField(max_length=100)

    def __str__(self):
        return f"{self.name}"


#За секој преведувач се чува име, националност и датум на раѓање.
class Translator(models.Model):
    name_translator = models.CharField(max_length=100)
    nationality = models.CharField(max_length=100)
    date_of_birth = models.DateField()

    def __str__(self):
        return f"{self.name_translator}"



#Секоја книга треба да има наслов, автор, жанрови, датум на издавање, корисник кој ја додал,
# број на страници, корица на книгата и информација дали е моментално достапна за читање.
class Book(models.Model):
    title = models.CharField(max_length=100)
    author = models.CharField(max_length=100)
    genre = models.ForeignKey(Genre, on_delete=models.CASCADE)
    date = models.DateField()
    user = models.ForeignKey(User, on_delete=models.CASCADE)
    num_pages = models.IntegerField()
    cover_image = models.ImageField(upload_to="covers/", null=True, blank=True)
    available = models.BooleanField(default=True)
    translator = models.ForeignKey(Translator, on_delete=models.CASCADE)

    def __str__(self):
        return f"{self.title} {self.author}"


#секој рејтинг содржи корисник, оценка и коментар, а само корисникот што го оставил рејтингот може да го избрише.
class Rating(models.Model):
    user = models.ForeignKey(User, on_delete=models.CASCADE)
    book = models.ForeignKey(Book, on_delete=models.CASCADE)
    grade = models.IntegerField()
    comment = models.CharField(max_length=100)

    def __str__(self):
        return f"{self.grade} {self.comment}"



#Системот треба да евидентира и преведувачи за книгите, при што еден преведувач може да работи на повеќе книги,
# а една книга може да има повеќе преведувачи.
class BooksTranslators(models.Model):
    book = models.ForeignKey(Book, on_delete=models.CASCADE)
    translator = models.ForeignKey(Translator, on_delete=models.CASCADE)

    def __str__(self):
        return f"{self.book} {self.translator}"