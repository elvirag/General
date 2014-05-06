#define FOREVER for(;;)

typedef struct {
double real;
double imaginary;
}complex[] = {
{'a', &a},
{'b', &b},
{'c', &c},
{'d', &d},
{'e', &e},
{'f', &f},
{'A', &a},
{'B', &b},
{'C', &c},
{'D', &d},
{'E', &e},
{'F', &f},
{'#',NULL}
};

void read_comp();
void print_comp();
void add_comp();
void sub_comp();
void mult_comp_real();
void mult_comp_img();
void mult_comp_comp();
void abs_comp();
void halt();



