from django.urls import path, include
from rest_framework.routers import DefaultRouter
from .views import CitaViewSet

router = DefaultRouter()
router.register(r'citas', CitaViewSet)

urlpatterns = [
    path('', include(router.urls)),
]