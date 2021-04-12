#include <stdio.h>
#include "Funkcje.h"
#define _CRTDBG_MAP_ALLOC
int main(int argc, char** argv)
{
	{
		if (argc == 1)
			printf("Pomoc: Program kompresuje podane w pliku wejsciowym dane lub dekompresuje skompresowane dane");

		else if (argc == 2)
		{
			for (int i = 0; i < argc; ++i)
			{
				if (!strcmp(argv[i], "-h"))
					printf("Pomoc: Program kompresuje podane w pliku wejsciowym dane lub dekompresuje skompresowane dane");
			}
		}
		if (argc != 11)
			printf("Podales niepoprawne parametry!");

		else
		{
			FILE *in, *out;
			char *bufor, *tryb, *slownik_char, *bufor_char;
			int rozmiar_slownika, rozmiar_bufora;

			for (int i = 0; i < argc; ++i)
			{
				if (!strcmp(argv[i], "-i"))
				{
					in = fopen(argv[++i], "rb"); //otwieram plik wejœciowy

					if (!in)
						printf("Nie udalo sie otworzyc pliku wejsciowego\n");
				}
				else if (!strcmp(argv[i], "-o"))
				{
					out = fopen(argv[++i], "wb"); //otwieram plik wyjœciowy

					if (!out)
						printf("Nie udalo sie zapisac pliku wyjsciowego\n");
				}
				else if (!strcmp(argv[i], "-t"))
					tryb = argv[++i];

				else if (!strcmp(argv[i], "-s"))
					slownik_char = argv[++i];

				else if (!strcmp(argv[i], "-b"))
					bufor_char = argv[++i];
			}

			fseek(in, 0, SEEK_END);		//przesuwan wska¿nik na koniec pliku
			int rozmiar = ftell(in);		//pobieram rozmiar pliku
			fseek(in, 0, SEEK_SET);		//powracam ze wska¿nikiem na pocz¹tek

			bufor = malloc(sizeof(char)*(2 * rozmiar + 1));		//alokuje pamiêæ	
			bufor[0] = 0;
			fread(bufor, sizeof(char), rozmiar, in); //kopiuje zawartoœæ pliku to zmiennej bufor
			bufor[rozmiar] = 0;	//na koniec dopisuje znak koñca

			if (!strcmp(tryb, "kompresja"))
				Kompresja(bufor, rozmiar, out, slownik_char, bufor_char);

			else if (!strcmp(tryb, "dekompresja"))
				Dekompresja(bufor, rozmiar, out, slownik_char, bufor_char);

			else
				printf("podano zly tryb przetwarzania");

			free(bufor);
			fclose(in);
			fclose(out);
		}
	}
	_CrtDumpMemoryLeaks();
	printf("Program napisal Jakub Lagodka\n");
}