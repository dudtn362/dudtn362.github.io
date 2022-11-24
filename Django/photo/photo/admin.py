# admin.py의 역할~~ Admin 사이트에 보이도록 등록 용도

from django.contrib import admin
from photo.models import Album, Photo


class PhotoInline(admin.StackedInline):
    model = Photo
    extra = 2


@admin.register(Album)
class AlbumAdmin(admin.ModelAdmin):
    inlines = (PhotoInline,)
    list_display = ('id', 'name', 'description')


@admin.register(Photo)
class PhotoAdmin(admin.ModelAdmin):
    list_display = ('id', 'title', 'upload_dt')

