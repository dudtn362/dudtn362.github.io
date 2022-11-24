from django.db import models
from django.urls import reverse
from taggit.managers import TaggableManager
from django.contrib.auth.models import User 
from django.utils.text import slugify

class Post(models.Model):
    # 기본적인 ID는 코딩이 생략되었음
    # 안녕 바보 멍청.. ==> title
    # 안녕바보멍청 ==>slug
    
    title = models.CharField(verbose_name='TITLE', max_length=50)          # help_text는 마우스 올렸을 때 보여주는 텍스트
    # 슬러그란 ~~ 페이지나 포스트를 설명하는 핵심단어의 집합(SlugField는 자동으로 인덱싱되어짐)
    slug = models.SlugField('SLUG', unique=True, allow_unicode=True, help_text='one word for title alias.')
    description = models.CharField('DESCRIPTION', max_length=100, blank=True, help_text='simple description text.')
    content = models.TextField('CONTENT') #
    create_dt = models.DateTimeField('CREATE DATE', auto_now_add=True) #auto_now_add ==자동으로 현시점 날짜가 툴력
    modify_dt = models.DateTimeField('MODIFY DATE', auto_now=True) #auto_now 위와 같으나 일부러 고치지않는한 고정되있다.
    tags = TaggableManager(blank=True) #클래스 객체로 태그를 잡아준다?
    owner = models.ForeignKey(User,on_delete=models.CASCADE,verbose_name='OWNER',blank=True,null=True)
    
    
    
    
    # INNER CLASS
    class Meta:
        verbose_name = 'post'
        verbose_name_plural = 'posts'  # plural 는 '복수'를 뜻한다.
        db_table = 'blog_posts'
        ordering = ('-modify_dt',)
    
    # 객체 표현 양식 -- 간편한 정보출력을 위해 오버라이딩(재정의)
    def __str__(self): 
        return self.title

    def get_absolute_url(self):
                    #blog는 앱이름
        return reverse('blog:post_detail', args=(self.slug,))

    def get_previous(self):
        return self.get_previous_by_modify_dt()

    def get_next(self):
        return self.get_next_by_modify_dt()
    
    def save(self,*args,**kwargs):
        self.slug = slugify(self.title, allow_unicode=True)
        super().save(*args,**kwargs)
        
