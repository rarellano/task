#!/usr/bin/python
print ("Tipado Dinamico")
x=8

print(type(x))

y=x
x="cabesa"

print(type(x))
print (y)
print (x)

lista_1=[1,2,3]
lista_2=lista_1

print (lista_1)
print (lista_2)

lista_1[0]="cabesa"
print (lista_1)
print (lista_2)

conjunto = {0,1,2}

conjunto2 = {0,1,21}
print (conjunto)

print (conjunto & conjunto2)

conjunto.add("cabesa")

print(conjunto)

print('''La cruzcampo de nuestra ciudad,
	siempre fría tiene que estar,
	en el baso, 
	o en la litrona, 
	siempre fría tiene que estar!!
	CRUZCAMPO!!''')
