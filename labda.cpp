#inlude <stdio.h>
#inlude <stdlib.h>
#inlude <curses.h>
#inlude <unistd.h>
#inlude <sys/ioctl.h>
main(void)
{
struct winsize w;
int xj=0, xk=0, yj=0, yk=0;
int mx, my;

WINDOW *ablak;
ablak=initscr();
noecho();
cbreak();
nodelay(ablak,true);

for(;;)
{
    ioctl(STDOUT_FILENO, TIOCGWINSZ, &w);
    mx=w.ws_col*2, my=w.ws_row*2;
    my--;

    xj=(xj-1)%mx;
    xk=(xk+1)%mx;

    yj=(yj-1)%my;
    yk=(yk+1)%my;

    clear();
    for(int j=0;j<mx-1;j++)
    {
        mvprintw(0,j,"-");
        mvprintw(my/2, j,"-");
    }
    mvprintw(abs((yj+(my-yk))/2),
             abs((xj+(mx-xk))/2));
             refresh();
             usleep(150000);
}
return 0;
}
