from django.db import models

# Create your models here.
class Doctor(models.Model):
    nombre=models.CharField(max_length=100)
    especialidad=models.CharField(max_length=100)
    experiencia=models.IntegerField()
    precio=models.DecimalField(max_digits=8,decimal_places=2)
    horario=models.CharField(max_length=100)
    disponible=models.BooleanField(default=True)

    def __str__(self):
        return f"{self.nombre} - {self.especialidad} - {self.experiencia} - {self.precio} - {self.horario} - {self.disponible}"