#include <stdio.h>
#include <stdlib.h>

long long fibonacci()
{
  char v1; // [rsp+7h] [rbp-919h]
  unsigned int v2; // [rsp+8h] [rbp-918h]
  int i; // [rsp+Ch] [rbp-914h]
  long long v4; // [rsp+10h] [rbp-910h]
  long long v5; // [rsp+18h] [rbp-908h]
  char buf; // [rsp+810h] [rbp-110h]
  unsigned long long v7; // [rsp+918h] [rbp-8h]

  // v7 = __readfsqword(0x28u);
  v4 = 0LL;
  v5 = 1LL;
  for ( i = 2; i <= 255; ++i )
    *(&v4 + i) = *(&v4 + i - 2) + *(&v4 + i - 1);
  while ( v1 != 110 )
  {
    printf("Which fibbonacci offset did you want to look up? ");
    scanf("%d", &v2);
    printf("Fibbonaci Number %d: %lu\n", v2, *(&v4 + (signed int)v2));
    printf("Want to learn another Fibbonaci number? (y/n) ");
    scanf("%s", &v1);
  }
  printf("Did you learn anything? ");
  read(0, &buf, 0x200uLL);
  // return __readfsqword(0x28u) ^ v7;
  return v7;
}

int main() {
  fibbonacci();
  return 0;
}