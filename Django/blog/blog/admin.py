from django.contrib import admin
from blog.models import Post


@admin.register(Post)
class PostAdmin(admin.ModelAdmin): 
    list_display  = ('id', 'title', 'modify_dt','tag_list') 
    list_filter   = ('modify_dt',) 
    search_fields = ('title', 'content') 
    prepopulated_fields = {'slug': ('title',)}  #타이틀로만 가지고 슬러그를 만들겠다.

    # 두 메소드 추가
    def get_queryset(self,request):
        return super().get_queryset(request).prefetch_related('tags')
    
    def tag_list(self,obj):
        return ','.join(o.name for o in obj.tags.all())