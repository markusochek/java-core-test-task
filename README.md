-*?Псевдокод
Данный псевдокод используется для описания алгоритмов.

1.	Отступ от левого поля указывает на уровень вложенности.
2.	Циклы while, for, repeat и условные конструкции имеют тот же смысл что и в pascal-е.
3.	Символ “--” обозначает комментарий
4.	Символ “:=” обозначает присваивание
5.	Переменные локальны в рамках процедуры если, не оговорено иначе.
6.	Индекс массива пишется в квадратных скобках, конструкция A[i] означает i элемент в массиве A
7.	Возможно использование объектов, состоящих из нескольких полей, или имеющих несколько атрибутов, значения поля записывается как ИмяПоля[ИмяОбъекта].
К примеру длинна массива A записывается как Length[A], что означают квадратные скобке выясняется по контексту, переменная обозначающая массив или объект является указателем на составляющие его данные, после присвоения y:=x для любого поля f будет выполнятся равенство f[y]=f[x], определение того что является атрибутом, функция переменная или что либо еще делается по контексту.
8.	Указатель может иметь специальное значение NIL не указывающая ни на какой объект.
9.	Параметры передаются по значению: вызванная процедура получает собственную копию параметров, изменения параметров внутри процедуры снаружи не видно. При передаче объектов копируется указатель на данные соответствующие этому объекту.

Задача по анализу алгоритма

Insertion-Sort(A)
1 for j  :=2 to length[A]
2    do key := A[j]
3	  i :=j - 1
4 	  while i > 0 and A[i] > key
5 	        do A[i + 1]  :=A[i]
6 	              i  :=i - 1
7 	  A[i + 1] := key
Опишите работу представленного выше алгоритма.
Достаточно составить таблицу, где для каждой итерации цикла по переменной j будет представлена строка с указанием порядка перемещений для каждого элемента. К примеру
j	A[1]	A[2]	A[3]	A[4]
1 (Дано)	3	2	1	5
		2

2	3	2	1	5
		



Задача по написанию алгоритма вставки в список

В связанном списке элементы линейно упорядочены, но порядок определяется не номерами, как в массиве, а указателями, входящими в состав элементов списка. Списки являются удобным способом реализации динамических множеств, позволяющим реализовать все операции, необходимые для работы с данными. Другими словами элемент двухстороннего связанного списка – это запись содержащая три поля Key (Ключ) и два указателя Next(Следующий) и prev (Предыдущий ) Помимо этого, элементы списка могут содержать дополнительные данные. Если х-Элемент списка То next[x]. Указывает на следующий элемент списка, а prev[x] – на предшествующий. Если prev[x]=NIL, то у элемента x нет предшествующего: это голова(Head) списка. Если next[x]=NIL, то x -  последний элемент списка или, как говорят его хвост (tail)
Прежде чем двигаться по указателям, надо знать хотя бы один элемент списка: мы предполагаем, что для списка L известен указатель head[L] на его голову. Если head[L]=NIL, то список пуст.
Для примера дана процедура поиска по списку:

Алгоритм поиска
List-Search(L; k)
1 x :=head[L]
2    while x != nil and key[x] != k
3         do x :=next[x]
4 return x 

Если забыть о ситуации, когда удаляется 1 или последний элемент списка то алгоритм удаления может быть записан в виде
List-Delete(L; x)
1   next[prev[x]]:=next[x]
2    prev[next[x]]:= prev[x]        
          
Рис списка:
 

Напишите процедуру вставки элемента в голову списка.
Учесть, что элемент списка может быть пустым.
Декларация вызова:

List-Insert(L; x)
(L – указатель на список, x-указатель на элемент списка)
Задача по распределению сумм.

Товарная позиция документа содержит три поля: количество, цена и сумма. Детализация товарной позиции документа содержит распределение количеств и сумм по людям. Количества в детализации вводятся вручную, суммы вычисляются автоматически.
Точность округления сумм – 2 знака, количества – 10 знаков.

Пример:
Товарная позиция
Номенклатура	Количество(кг)	Цена	Сумма(руб.)
Сахарный песок	58,21942216	10	582,19

Детализация
Фамилия	Количество(кг)	Округленное Количество*Цену	Распределение копеек	Сумма
Иванов	30,88848888	308,88000000	0,02	308,90000000
Петров	5,88848888	58,88000000	0,01	58,89000000
Сидоров	5,88848888	58,88000000	0	58,88000000
Малевин	5,88848888	58,88000000	 	58,88000000
Макаров	5,88848888	58,88000000	 	58,88000000
Сетченко	1,88848888		 	
Козлов	1,88848888		 	
Итого	58,21942216	582,16000000	 	582,19000000

Примечание: серым курсивом отображены служебные поля, демонстрирующие расхождения по копейкам, а также корректный разброс суммарного расхождения по позициям.

Необходимо вычислить суммы по позициям разбрасывая итоговые расхождения по копейкам при округлении, пропорционально количеству в позиции.

ЗАДАЧА:
•	Вычислить значение колонок «Округленное Количество*Цену», «Сумма» и «Распределение копеек» для «Сетченко» и «Козлова»
•	Написать формулы, по которой вычисляется колонка «Распределение копеек», для Иванова, Петрова, Сидорова.
•	Найти формулу, по которой вычисляется колонка «Сумма».
•	Написать общий алгоритм вычисления по детализации





РЕШЕНИЕ ЗАДАЧИ:
j	A[1]	A[2]	A[3]	A[4]	A[5]	A[6]	A[7]	A[8]	A[9]	A[10]
1	3	2	9	10	4	7	6	8	1	5
2	3	2	9	10	4	7	6	8	1	5
3	3	2	9	10	4	7	6	8	1	5
4	3	2	4	9	10	7	6	8	1	5
5	3	2	4	7	9	10	6	8	1	5
6	3	2	4	6	7	9	10	8	1	5
7	3	2	4	6	7	8	9	10	1	5
8	3	1	2	4	6	7	8	9	10	5
1.	Задача по анализу алгоритма
алгоритм сортировки вставками

1.	Цикл for начинается со второго элемента списка (индекс 2) и проходит до конца списка.
2.	Выбирается текущий элемент (key) для сортировки.
3.	Внутренний цикл while сравнивает key с предыдущими элементами списка:
o	Если предыдущий элемент больше key, он сдвигается вправо.
o	Этот процесс продолжается, пока не будет найдена правильная позиция для key.
4.	После нахождения правильной позиции, key вставляется в эту позицию.
5.	Процесс повторяется для всех элементов списка.
В результате, список A будет отсортирован по возрастанию.

так как в коде есть 2 изменения: j начинается с 2 и i > 0, а не i >= 0 то сортировка не работает для первого и последнего элемента

Здесь представлен алгоритм работы, этот алгоритм реализован на java, с ним вы можете ознакомится с ним здесь:
https://github.com/markusochek/java-core-test-task

2.	Задача по написанию алгоритма вставки в список

Алгоритм List-Insert(L, x)
// Устанавливаем следующий элемент x на текущую голову списка
next[x] := head[L]
// У нового элемента нет предыдущего, так как он станет головой
prev[x] := NIL

if head[L] != NIL then
// Если список не пуст, обновляем prev у текущей головы
prev[head[L]] := x
else
	// Если список был пуст, x становится и хвостом
tail[L] := x
// Устанавливаем x как новую голову списка
head[L] := x

Здесь представлен псевдокод, с алгоритмом реализованном на java, вы можете ознакомится здесь:
https://github.com/markusochek/java-core-test-task

3.	Задача по распределению сумм.
Вычисление "Округленное Количество*Цену" для Сетченко и Козлова:
1,88848888 * 10 = 18,8848888
Округляем до 2 знаков: 18,88
Формула для "Распределения копеек":
Общее расхождение = Сумма товарной позиции - Сумма округленных (Количество*Цену)
= 582,19 - 582,16 = 0,03
Распределение для каждой позиции = Округление до 2 знаков (Расхождение * (Количество позиции / Общее количество))
Для Иванова: Округление (0,03 * (30,88848888 / 58,21942216)) = 0,02
Для Петрова: Округление (0,03 * (5,88848888 / 58,21942216)) = 0,01
Для Сидорова: Округление (0,03 * (5,88848888 / 58,21942216)) = 0,00
Формула для "Суммы":
Сумма = Округленное (Количество*Цену) + Распределение копеек
Общий алгоритм вычисления по детализации:
a) Вычислить "Округленное Количество * Цену" для всех позиций
b) Посчитать общее расхождение
c) Распределить расхождение по позициям пропорционально их количеству
d) Округлить распределенные расхождения до 2 знаков
e) Если после распределения осталось нераспределенное расхождение,
добавить его к позиции с наибольшим количеством
f) Вычислить итоговые суммы для каждой позиции
Применяя этот алгоритм к Сетченко и Козлову:
Сетченко:
Округленное Количество*Цену: 18,88
Распределение копеек: 0,00 (из-за малого количества)
Сумма: 18,88
Козлов:
Округленное Количество*Цену: 18,88
Распределение копеек: 0,00 (из-за малого количества)
Сумма: 18,88
Заметим, что из-за округления может остаться нераспределенная копейка. В таком случае ее следует добавить к позиции с наибольшим количеством (в данном случае, к Иванову).
