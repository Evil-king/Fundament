package com.hwq.fundament.JavaDataStructure.recursion;

/**
 * @Auther: Administrator
 * @Date: 2020/2/28 0028 16:44
 * @Description: 迷宫问题
 */
public class MiGong {
    public static void main(String[] args) {
        //先创建一个二维数组 模拟迷宫
        int[][] map = new int[8][7];
        //1表示墙 上下都全部设置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1; //第0行所有列都为1
            map[7][i] = 1; //第7行所有列都为1
        }
        //左右全部设置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;//第0列全部为1
            map[i][6] = 1;//第6列全部为1
        }
        //设置挡板为1
        map[3][1] = 1;
        map[3][2] = 1;

        System.out.println("地图情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+"");
            }
            System.out.println();
        }

        setWay(map,1,1);
        System.out.println("小球走过，并标识过的 地图情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+"");
            }
            System.out.println();
        }



    }
    //使用递归回溯来给小球找路
    //说明
    //1、map 表示地图
    //2、i j表示从地图的哪个位置开始出发
    //3、如果小球能到map[6][5]位置，说明通路找到
    //4、约定 当map[i][j] 为0 表示该点没有走过 当为1 表示墙；2 表示可以走 3 表示已经走过，走不通
    //5、走迷宫的策略(这个可以根据自己喜好自定义) 下-右-上-左 如果走不通则回溯

    /**
     *
     * @param map 表示地图
     * @param i 1
     * @param j 1
     * @return
     */
    public static boolean setWay(int[][] map,int i,int j){
        if(map[6][5] == 2){ //已经找到通路
            return true;
        } else {
            if(map[i][j] == 0){ //表示该点没有走过
                map[i][j] = 2;//假定可以走通 则按照策略走
                if(setWay(map,i+1,j)){ //向下走
                    return true;
                } else if(setWay(map,i,j+1)){ //向右走
                    return true;
                } else if(setWay(map,i-1,j)){ //向上走
                    return true;
                } else if(setWay(map,i,j-1)){ //向左走
                    return true;
                }  else{
                    map[i][j] = 3;//表示都走不通
                    return false;
                }
            } else {
                return false;
            }
        }
    }

}
