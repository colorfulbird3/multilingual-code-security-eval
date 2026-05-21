

## Voorbeeld

1. Deze pagina is die hulle herleidingsdiens.

"""
from __future__ import unicode_literals

from django.conf.urls import url

from. import views

urlpatterns = [
    url(r'^$', views.index, name='index'),
    url(r'^redirect/', views.perform_redirect, name='redirect'),
]
