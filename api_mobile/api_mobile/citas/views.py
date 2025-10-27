from rest_framework import viewsets
from .models import Citas
from .serializers import CitaSerializer

# Create your views here.

class CitaViewSet(viewsets.ModelViewSet):
    queryset = Citas.objects.all()
    serializer_class = CitaSerializer