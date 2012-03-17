function comecaComMaiuscula(texto) {
	var resultado = /^[A-Z]+.*$/.test(texto);
	return resultado;
}

function possuiMinimoDeCaracteres(texto, tamanhoMinimo) {
	return texto.length > tamanhoMinimo
}