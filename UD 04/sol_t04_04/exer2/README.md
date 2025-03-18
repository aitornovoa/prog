Exercicio 2. Deséxase realizar un xestor de tarefas persoal. Para iso crea un programa co seguinte menú de inicio:

i) Iniciar sesión: o usuario debe introducir o seu nome de usuario e contrasinal. Se as credenciais son correctas mostrarase a seguinte mensaxe de benvida: Benvido <nomeDePila>. A continuación mostrarase o menú principal.

r) Rexistrarse: o usuario poderá rexistrarse na aplicación introducindo o seu nome de pila, o nome de usuario e o seu contrasinal 2 veces. Debes comprobar que o nome de usuario non existe na aplicación e que os contrasinais introducidos coinciden. Ademais o contrasinal debe de conter unha letra maiúscula, unha minúscula e un número e non se debe de almacenar en raw senón que debes gardalo utilizando o seu hash.

s) Saír do programa: cérrase o programa.

O menú principal consta do seguinte menú:

a) Modificar nome. O usuario pode modificar o seu nome de pila.

b) Ingresar tarefa pendente. O usuario debe poder introducir unha tarefa. Cada tarefa consta dun título, unha descrición, e a data e hora límite para realizar a tarefa no formato dd/MM/yyyy HH:mm. Tamén se deberá almacenar en que momento se introduciu a tarefa.

c) Mostrar tarefas pendentes. O usuario poderá ver as tarefas pendentes por facer. Débese mostrar un menú onde se mostra o título de cada tarefa. O usuario poderá seleccionar unha tarefa e ver a súa descrición, data de introdución e data límite no formato dd/MM/yyyy HH:mm.

d) Marcar tarefa como realizada. O usuario poderá marcar as tarefas pendentes como realizadas. Débese mostrar un menú onde se mostra o título de cada tarefa. O usuario a través deste menú indicará que tarefa desexa marcar como realizada.

e) Mostrar tarefas pendentes nas próximas 48 horas. Similar ao punto c).

f) Mostrar tarefas realizadas. Similar ao punto c).

g) Mostrar tarefas pendentes pero que se sobrepasou a data e hora límite. Similar ao punto c).

h) Cerrar sesión. Irase ao menú de inicio de sesión.

Xerar Javadoc:

```bash
javadoc -d doc -sourcepath src -subpackages XestorTarefas
```