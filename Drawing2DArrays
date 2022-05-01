import java.util.Arrays;

/**
 * java class for two dimensional array filling
 * @author Oyku Elis Turegun 21902976
 * @version 01.12.2021
 */

public class FillBox {

    public static void main(String[] arg){

        char[][] arr2 = createArray(25,25);

        drawFigure(arr2,0,0,25);
        printArray(arr2);

        System.out.println();

        char[][] arr3 = createArray(49,49);

        drawFigure(arr3,0,0,49);
        printArray(arr3);

    }


    /**
     * method for creating new array with edges
     * @param row
     * @param column
     * @return new array with edges filled with #
     */
    public static char[][] createArray(int row, int column){
        char sq = '#';
        char[][] arr = new char[row][column];

        //filling edges with #
        for(int i = 0; i< row; i++){
            arr[i][0] = sq;
            arr[i][column-1] = sq;

            for(int j = 0; j < column; j++){
                arr[0][j] = sq;
                arr[row-1][j] = sq;

            }
        }
        //putting space inside
        for(int k = 0; k < row-2; k++){
            for(int n = 0; n < column -2; n++) {
                arr[k + 1][n+1] = ' ';
            }
        }
        return arr;
    }

    /**
     * method to print all elements of two dimensional array by visiting them with for loop
     * @param array
     */
    public static void printArray(char[][] array){
        int row = array.length;
        int column = array[0].length;

        //visiting all elements
        for(int i = 0; i < row; i++){
            for(int k = 0; k < column; k++){
                System.out.print(array[i][k] + " ");
            }
            System.out.println();
        }

    }


    /**
     * filling box with given character if element is not #
     * @param array
     * @param row
     * @param column
     * @param ch
     */
    public static void fillBox(char[][] array, int row, int column, char ch){
        if(array[row][column] == ' '){
            array[row][column] = ch;

            //checking hte neighbours
            fillBox(array,row-1,column,ch);
            fillBox(array,row+1,column,ch);
            fillBox(array,row,column-1,ch);
            fillBox(array,row,column+1,ch);

        }
    }

    /**
     * recursive method to make quadrants in a box
     * @param square
     * @param x
     * @param y
     * @param size
     */
    public static void drawFigure(char[][] square, int x, int y, int size){


        if( size > 7) {
            for (int i = 0; i < square.length; i++) {
                square[i][size / 2 + y] = '#';
                square[size / 2 + x][i] = '#';

            }

            drawFigure(square,x+size/2,y,size/2);
            drawFigure(square, x+size/2, y+size/2,size/2);
            drawFigure(square, x, y+size/2,size/2);
            drawFigure(square,x,y,size/2);

        }
        else {
            fillBox(square, x+1, y+1, '*');
        }
    }

}
