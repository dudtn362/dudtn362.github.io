from django.db import models
from django.contrib.auth.models import User 

# Create your models here. 데이터베이스 테이블을 만들어 주는 모델들(vo클래스들)
class Bookmark(models.Model):
    # id 넘버링 필드는 자동으로 만들어 진다.
    title = models.CharField('TITLE',max_length=100,blank=True)
    url = models.URLField('URL',unique=True) # 'URL'은 url컬럼의 별칭임
    owner = models.ForeignKey(User,on_delete=models.CASCADE,blank=True,null=True)
    
    
    
    # 객체 표현 양식 : java==>toString()
    #오버라이딩하는 것
    def __str__(self):
        return self.title
    
    
