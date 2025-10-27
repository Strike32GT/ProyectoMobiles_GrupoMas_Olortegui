from django.db import models

# Create your models here.

class Citas(models.Model):
    doctor=models.CharField(max_length=100)
    especialidad=models.CharField(max_length=100)
    fecha=models.CharField(max_length=50)
    hora=models.CharField(max_length=50)
    tipo=models.CharField(max_length=50)

    def __str__(self):
        return f"{self.doctor} - {self.especialidad} - {self.fecha} - {self.hora} - {self.tipo}"
