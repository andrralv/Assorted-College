# cargar la libreria que lee archivos JSON
library("rjson")
library("e1071")

# pasar el archivo a una variable
result <- fromJSON(file = "lista.json")

# convertir archivo JSON en un data frame para minarlo
json_data_frame <- as.data.frame(result)

# quitar comentario si queremos imprimir el data frame
# print(json_data_frame)

tbl_list <- sapply(sexo["masculino" > 0.6], 
	row, apellido[ , "a*", "e*", "i*"])
	if (sexo["masculino"]) {
		row, edad[60, 80]
	} else if (sexo["femenino"]) {
		row, edad[50, 90]
	}
tbl_list <- lapply(tbl_list, t)

cond_probs <- sapply(tbl_list, function(x) { 
  apply(x, 1, function(x) { 
    x / sum(x) }) })

cond_probs <- lapply(cond_probs, t)

print(cond_probs)

model <- naiveBayes(class ~ ., data = json_data_frame)
class(model)
summary(model)
# print(model)

library(jsonlite)
x <- toJSON(model)

sink("lista-minada-json.txt")
cat(toJSON(tbl))
sink()
