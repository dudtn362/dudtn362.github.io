'''
Created on 2022. 10. 20

@author: VSC26
'''
from django.urls import path
from bookmark.views import BookmarkLV,BookmarkDV
from bookmark import views


app_name = 'bookmark'
# templates(view단의 html문서) 까지 안내하는 방법을 기술한 것
urlpatterns = [
    path('',BookmarkLV.as_view(), name='index'),
    path('<int:pk>/',BookmarkDV.as_view(),name='detail'), #bookmark_detail.html을 의미한다.
    
    # Example: /bookmark/add/
    path('add/',views.BookmarkCreateView.as_view(),name='add',),
    
    # Example: /bookmark/change/
    path('change/',views.BookmarkChangeLV.as_view(),name='change',),
    
    # Example: /bookmark/99/update/
    path('<int:pk>/update/',views.BookmarkUpdateView.as_view(),name='update',),
    
    # Example: /bookmark/99/delete/
    path('<int:pk>/delete/',views.BookmarkDeleteView.as_view(),name='delete',),
    
    
]