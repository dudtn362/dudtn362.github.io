
from django.contrib import admin
from django.urls import path,include
from pys_site.views import HomeView
from django.conf.urls.static import static
from django.conf import settings
from pys_site.views import UserCreateView,UserCreateDoneTV

# urlpatterns = [
#     path("admin/", admin.site.urls), # 고칠 수 없는 부분
#     
#     # class-based view(CBV), function-based view(FBV) 
# #     path("bookmark/",BookmarkLV.as_view(),name="index"), # 북마크 정보의 리스트 뿌려줌
# #     path("bookmark/<int:pk>/",BookmarkDV.as_view(),name="detail"),
#     
#     
#     
# ]


urlpatterns = [
    path('polls/',include('polls.urls')),
    ################################################
    path('',HomeView.as_view(),name="home"),
    path('admin/', admin.site.urls),
    
    path('bookmark/', include('bookmark.urls')),
    path('blog/', include('blog.urls')),
    path('photo/', include('photo.urls')),
    # 인증기능
    path("accounts/",include('django.contrib.auth.urls')),
    path('accounts/register/',UserCreateView.as_view(),name='register'),
    path('accounts/register/done/',UserCreateDoneTV.as_view(),name='register_done'),
    
    
    
] + static(settings.MEDIA_URL,document_root = settings.MEDIA_ROOT)
