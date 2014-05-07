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

void read_comp(void);
void print_comp(void);
void add_comp(void);
void sub_comp(void);
void mult_comp_real(void);
void mult_comp_img(void);
void mult_comp_comp(void);
void abs_comp(void);
void halt(void);

struct{
char *name;
void (*func)(void);
}cmd[]={
{"read_comp",read_comp},
{"print_comp",print_comp},
{"add_comp",add_comp},
{"sub_comp",sub_comp},
{"mult_comp_real",mult_comp_real},
{"mult_comp_img",mult_comp_img},
{"mult_comp_comp",mult_comp_comp},
{"abs_comp",abs_comp},
{"halt",halt},
{"not_valid",NULL}
};



