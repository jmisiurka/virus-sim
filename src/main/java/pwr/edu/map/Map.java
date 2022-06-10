package pwr.edu.map;

public class Map {
    private final int size;
    private CellState tiles[][];

    public Map(int size)
    {
        this.size = size;
        tiles = new CellState[size][size];
        clearMap();
    }

    public void setCellState(int row, int column, CellState state)
    {
        tiles[row][column] = state;
    }

    public void setCellState(Point cell, CellState state)
    {
        tiles[cell.x][cell.y] = state;
    }

    public void clearMap()
    {
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                setCellState(i, j, CellState.EMPTY);
            }
        }
    }

//    private void printMap()
//    {
//        for (int row = 0; row < size; row++)
//        {
//            for (int column = 0; column < size; column++)
//            {
//                switch (tiles[row][column])
//                {
//                    case EMPTY:
//
//                        break;
//                    case HEALTHY_PERSON:
//                        break;
//                    case INFECTED_PERSON:
//                        break;
//                }
//            }
//            System.out.println();
//        }
//        System.out.println("---------------------------------------");
//    }
}
