#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>



int main(int argc, char ** argv)
{
	if (argc != 4)
	{
		printf("blad, niewlasciwa liczba parametrow");
	}
	else
	{
		char * plikWej = argv[1];
		char * plikWyj = argv[2];
		char * trybPrze = argv[3];
		char * buffer;
		long rozmiar;
		size_t result;
		FILE * pWej;
		pWej = fopen(plikWej, "rb");
		if (pWej != NULL)
		{
			FILE * pWyj;
			pWyj = fopen(plikWyj, "wb");
			if (pWyj != NULL)
			{
				fseek(pWej, 0, SEEK_END);
				rozmiar = ftell(pWej);
				rewind(pWej);
				buffer = (char*)malloc(sizeof(char)*(rozmiar + 1));
				result = fread(buffer, sizeof(char), rozmiar, pWej);
				buffer[rozmiar] = '\0';

				if (!strcmp(trybPrze, "-skompresuj"))
				{
					fwrite(buffer, sizeof(char), rozmiar, pWyj);
				}
				else if (!strcmp(trybPrze, "-wypakuj"))
				{

					fwrite(buffer, sizeof(char), rozmiar, pWyj);
				}
				else
				{
					printf("blad, zly tryb przetwarzania");
				}
				free(buffer);
				fclose(pWyj);
			}
			else
			{
				printf("blad z Plikiem Wyjsciowym");
			}
			fclose(pWej);
		}
		else
		{
			printf("blad z Plikiem Wejsciowym");
		}
	}
	return 0;
}