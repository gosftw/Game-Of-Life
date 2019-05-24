package life;

import java.util.Random;

public class Model {

    int n, count;
    char[][] mat, generated;

    public Model(int n){
        this.n = n;
        mat = new char[n][n];
        generated = new char[n][n];
        Random rand = new Random();
        count = 0;
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j++){
                if(rand.nextBoolean()){
                    mat[i][j] = 'O';
                    generated[i][j] = 'O';
                    count ++;
                }
                else{
                    mat[i][j] = ' ';
                    generated[i][j] = ' ';
                }
            }
        }
    }

    public String toString(){
        String str = "";
        str += "Generation # ";
        str += "Alive: " + count;
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j++){
                str += generated[i][j];
            }
            str += "\n";
        }
        str += "\n";
        return str;
    }

    public void generate_next() {
        int neighbors;
        count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                neighbors = check_neighbors(i, j);
                if(mat[i][j] == 'O'){
                    if(neighbors != 2 && neighbors != 3){
                        generated[i][j] = ' ';
                    }
                    else{
                        count += 1;
                    }
                }
                else{
                    if(neighbors == 3){
                        generated[i][j] = 'O';
                        count += 1;
                    }
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                mat[i][j] = generated[i][j];
            }
        }
    }

    private int check_neighbors(int i, int j){
        int i_less = (((i - 1) % n) + n) % n;
        int j_less = (((j - 1) % n) + n) % n;
        int i_more = (i + 1) % n;
        int j_more = (j + 1) % n;
        int c = 0;
        if(mat[i_less][j_less] == 'O'){
            c ++;
        }
        if(mat[i_less][j] == 'O'){
            c ++;
        }
        if(mat[i_less][j_more] == 'O'){
            c ++;
        }
        if(mat[i][j_less] == 'O'){
            c ++;
        }
        if(mat[i][j_more] == 'O'){
            c ++;
        }
        if(mat[i_more][j_less] == 'O'){
            c ++;
        }
        if(mat[i_more][j] == 'O'){
            c ++;
        }
        if(mat[i_more][j_more] == 'O'){
            c ++;
        }
        return c;
    }
}
