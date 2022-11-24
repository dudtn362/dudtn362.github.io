from django.contrib import admin
from bookmark.models import Bookmark

# Register your models here.
# 관리자가 관리할 디비로 등록
@admin.register(Bookmark) # 어드민 사이트에 등록하는 데코레이션(애너테이션)
class BookmarkAdmin(admin.ModelAdmin):
    list_display = ('id','title','url')

# 위 데코레이션 대신에 아래와 같이 등록할 수도 있음
# admin.site.register(Bookmark,BookmarkAdmin)
