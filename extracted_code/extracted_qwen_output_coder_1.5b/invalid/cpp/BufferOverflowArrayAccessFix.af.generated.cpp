## problem
Die implementatie van `parse_container_layers` is mislukend. Dit maakt gebruik van `char** layer_data`, maar het wordt gebruikt om een `int`-array te beheren. Dit maakt uit dat die functie niet kan werken met arrays van type `char`. Implementeer die functie om die typen correct te gebruiken en om te werken met arrays van type `int`.

## solution
Implementeer die functie `parse_container_layers` om die typen correct te gebruiken en om te werken met arrays van type `int`.