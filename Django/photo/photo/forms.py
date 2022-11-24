from django.forms import inlineformset_factory  
from photo.models import Album, Photo  

# 1:다 관계를 화면폼으로 만들 때에 다측의 데이터를 관리하기 위한 폼
PhotoInlineFormSet = inlineformset_factory(Album, Photo,
    fields = ['image', 'title', 'description'], 
    extra = 2) # extra = 2란 의미는 빈 셑을 2개를 장만한다.

