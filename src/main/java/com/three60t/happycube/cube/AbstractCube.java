package com.three60t.happycube.cube;

import com.three60t.happycube.condition.Condition;
import com.three60t.happycube.condition.EdgeMiddleMatchCondition;
import com.three60t.happycube.condition.VertexMatchCondition;
import com.three60t.happycube.enums.PuzzlePieceEdge;
import com.three60t.happycube.enums.PuzzleSide;
import com.three60t.happycube.orientation.Orientation;
import com.three60t.happycube.puzzle.Puzzle;
import com.three60t.happycube.puzzle.PuzzlePiece;
import com.three60t.happycube.utils.Permutations;
import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * This abstract class contains all static data structures e.g. CONDITIONS, ORIENTATIONS
 * And contains all non-static data structures e.g. inputPuzzle, solutions.
 * Additionally some private methods used by findSolutions and saveSolutions methods must
 * be place in this class.
 *
 * @author Hossein Moradi
 * @since 3/15/19
 */
public abstract class AbstractCube implements Cube {
    private static Logger logger = Logger.getLogger(AbstractCube.class.getName());

    //For each puzzle-piece, we have to check 20 conditions according to analysis (12 for edges, 8 for vertices)
    private final static List<Condition> CONDITIONS = new ArrayList<>(20);
    //Each puzzle-piece can have 8 different orientations according to rotating and mirroring
    private final static List<Orientation> ORIENTATIONS = new ArrayList<>(8);
    // This field contains input data given by concrete classes, e.g. BlueCube
    private Puzzle inputPuzzle;
    // This field contains solution(s) (In the base task you are only required to find one solution)
    private ConcurrentHashMap<Integer, Puzzle> solutions = new ConcurrentHashMap<>();

    static {
        //conditions for middle of edges (not vertices) --> 12 conditions
        CONDITIONS.add(new EdgeMiddleMatchCondition(PuzzleSide.TOP, PuzzlePieceEdge.TOP, PuzzleSide.BACK, PuzzlePieceEdge.TOP));
        CONDITIONS.add(new EdgeMiddleMatchCondition(PuzzleSide.TOP, PuzzlePieceEdge.BOTTOM, PuzzleSide.FRONT, PuzzlePieceEdge.TOP));
        CONDITIONS.add(new EdgeMiddleMatchCondition(PuzzleSide.TOP, PuzzlePieceEdge.LEFT, PuzzleSide.LEFT, PuzzlePieceEdge.TOP));
        CONDITIONS.add(new EdgeMiddleMatchCondition(PuzzleSide.TOP, PuzzlePieceEdge.RIGHT, PuzzleSide.RIGHT, PuzzlePieceEdge.TOP));
        CONDITIONS.add(new EdgeMiddleMatchCondition(PuzzleSide.BOTTOM, PuzzlePieceEdge.TOP, PuzzleSide.FRONT, PuzzlePieceEdge.BOTTOM));
        CONDITIONS.add(new EdgeMiddleMatchCondition(PuzzleSide.BOTTOM, PuzzlePieceEdge.BOTTOM, PuzzleSide.BACK, PuzzlePieceEdge.BOTTOM));
        CONDITIONS.add(new EdgeMiddleMatchCondition(PuzzleSide.BOTTOM, PuzzlePieceEdge.LEFT, PuzzleSide.LEFT, PuzzlePieceEdge.BOTTOM));
        CONDITIONS.add(new EdgeMiddleMatchCondition(PuzzleSide.BOTTOM, PuzzlePieceEdge.RIGHT, PuzzleSide.RIGHT, PuzzlePieceEdge.BOTTOM));
        CONDITIONS.add(new EdgeMiddleMatchCondition(PuzzleSide.BACK, PuzzlePieceEdge.LEFT, PuzzleSide.RIGHT, PuzzlePieceEdge.RIGHT));
        CONDITIONS.add(new EdgeMiddleMatchCondition(PuzzleSide.BACK, PuzzlePieceEdge.RIGHT, PuzzleSide.LEFT, PuzzlePieceEdge.LEFT));
        CONDITIONS.add(new EdgeMiddleMatchCondition(PuzzleSide.FRONT, PuzzlePieceEdge.RIGHT, PuzzleSide.RIGHT, PuzzlePieceEdge.LEFT));
        CONDITIONS.add(new EdgeMiddleMatchCondition(PuzzleSide.FRONT, PuzzlePieceEdge.LEFT, PuzzleSide.LEFT, PuzzlePieceEdge.RIGHT));

        //conditions just for vertices --> 8 conditions
        CONDITIONS.add(new VertexMatchCondition(PuzzleSide.TOP, PuzzlePieceEdge.TOP, 4, PuzzleSide.RIGHT, PuzzlePieceEdge.TOP, 4, PuzzleSide.BACK, PuzzlePieceEdge.TOP, 0)); //condition1
        CONDITIONS.add(new VertexMatchCondition(PuzzleSide.TOP, PuzzlePieceEdge.TOP, 0, PuzzleSide.LEFT, PuzzlePieceEdge.TOP, 0, PuzzleSide.BACK, PuzzlePieceEdge.TOP, 4)); //condition2
        CONDITIONS.add(new VertexMatchCondition(PuzzleSide.TOP, PuzzlePieceEdge.BOTTOM, 0, PuzzleSide.FRONT, PuzzlePieceEdge.TOP, 4, PuzzleSide.RIGHT, PuzzlePieceEdge.TOP, 0));//condition3
        CONDITIONS.add(new VertexMatchCondition(PuzzleSide.TOP, PuzzlePieceEdge.BOTTOM, 4, PuzzleSide.FRONT, PuzzlePieceEdge.TOP, 0, PuzzleSide.LEFT, PuzzlePieceEdge.TOP, 4));//condition4
        CONDITIONS.add(new VertexMatchCondition(PuzzleSide.BOTTOM, PuzzlePieceEdge.BOTTOM, 0, PuzzleSide.RIGHT, PuzzlePieceEdge.BOTTOM, 0, PuzzleSide.BACK, PuzzlePieceEdge.BOTTOM, 4));//condition5
        CONDITIONS.add(new VertexMatchCondition(PuzzleSide.BOTTOM, PuzzlePieceEdge.BOTTOM, 4, PuzzleSide.LEFT, PuzzlePieceEdge.BOTTOM, 4, PuzzleSide.BACK, PuzzlePieceEdge.BOTTOM, 0));//condition6
        CONDITIONS.add(new VertexMatchCondition(PuzzleSide.BOTTOM, PuzzlePieceEdge.TOP, 4, PuzzleSide.RIGHT, PuzzlePieceEdge.BOTTOM, 4, PuzzleSide.FRONT, PuzzlePieceEdge.BOTTOM, 0));//condition7
        CONDITIONS.add(new VertexMatchCondition(PuzzleSide.BOTTOM, PuzzlePieceEdge.TOP, 0, PuzzleSide.LEFT, PuzzlePieceEdge.BOTTOM, 0, PuzzleSide.FRONT, PuzzlePieceEdge.BOTTOM, 4));//condition8

        // initialize ORIENTATIONS (contains 8 ORIENTATIONS)
        ORIENTATIONS.add(new Orientation(PuzzlePieceEdge.TOP, PuzzlePieceEdge.RIGHT, PuzzlePieceEdge.BOTTOM, PuzzlePieceEdge.LEFT, false)); // Orientation1
        ORIENTATIONS.add(new Orientation(PuzzlePieceEdge.LEFT, PuzzlePieceEdge.TOP, PuzzlePieceEdge.RIGHT, PuzzlePieceEdge.BOTTOM, false)); // Orientation2
        ORIENTATIONS.add(new Orientation(PuzzlePieceEdge.BOTTOM, PuzzlePieceEdge.LEFT, PuzzlePieceEdge.TOP, PuzzlePieceEdge.RIGHT, false)); // Orientation3
        ORIENTATIONS.add(new Orientation(PuzzlePieceEdge.RIGHT, PuzzlePieceEdge.BOTTOM, PuzzlePieceEdge.LEFT, PuzzlePieceEdge.TOP, false)); // Orientation4
        // ORIENTATIONS by mirroring
        ORIENTATIONS.add(new Orientation(PuzzlePieceEdge.TOP, PuzzlePieceEdge.LEFT, PuzzlePieceEdge.BOTTOM, PuzzlePieceEdge.RIGHT, true)); // Orientation5
        ORIENTATIONS.add(new Orientation(PuzzlePieceEdge.RIGHT, PuzzlePieceEdge.TOP, PuzzlePieceEdge.LEFT, PuzzlePieceEdge.BOTTOM, true)); // Orientation6
        ORIENTATIONS.add(new Orientation(PuzzlePieceEdge.BOTTOM, PuzzlePieceEdge.RIGHT, PuzzlePieceEdge.TOP, PuzzlePieceEdge.LEFT, true)); // Orientation7
        ORIENTATIONS.add(new Orientation(PuzzlePieceEdge.LEFT, PuzzlePieceEdge.BOTTOM, PuzzlePieceEdge.RIGHT, PuzzlePieceEdge.TOP, true)); // Orientation8
    }

    AbstractCube() {
        this.inputPuzzle = initiateCube();
    }

    public Puzzle getInputPuzzle() {
        return inputPuzzle;
    }

    @Override
    public Map<Integer, Puzzle> findSolutions() {
        //find all possible cases that 6 puzzlePieces can be placed in 6 places (side of cube)
        if (Permutations.of(Arrays.asList(1, 2, 3, 4, 5, 6))
                .map(p -> p.collect(Collectors.toList()))
                .map(puzzleNumbers ->
                        new Puzzle(this.inputPuzzle.getPuzzlePiece(PuzzleSide.findByValue(puzzleNumbers.get(0))),
                                this.inputPuzzle.getPuzzlePiece(PuzzleSide.findByValue(puzzleNumbers.get(1))),
                                this.inputPuzzle.getPuzzlePiece(PuzzleSide.findByValue(puzzleNumbers.get(2))),
                                this.inputPuzzle.getPuzzlePiece(PuzzleSide.findByValue(puzzleNumbers.get(3))),
                                this.inputPuzzle.getPuzzlePiece(PuzzleSide.findByValue(puzzleNumbers.get(4))),
                                this.inputPuzzle.getPuzzlePiece(PuzzleSide.findByValue(puzzleNumbers.get(5)))))
                .anyMatch(this::checkStatesByOrientations)) {
            return solutions;
        }
        return null;
    }

    @Override
    public void saveSolutions() {
        //save solutions in unfolded format in a separate files for each solution (At this time, we have just one solution)
        // The result will print in 3 rows and each row have 4 columns:
        //
        // row1 -->        col2
        // row2 -->  col1  clo2  col3  col4
        // row2 -->        clo2
        //
        //Example (of red cube):
        //
        //      oo o
        //      ooo
        //     ooooo
        //      ooo
        //     oo
        // o o   oo oo oo  o
        //oooo ooooo ooo oooo
        // oooo ooo ooooo oooo
        //oooo ooooo ooo oooo
        // o   o o   oo    o
        //      o oo
        //     oooo
        //     oooo
        //      oooo
        //     oo oo
        //
        String directory = "output";
        File dir = new File(directory);
        if (!dir.exists()) dir.mkdirs();
        AtomicInteger counter = new AtomicInteger(1);
        solutions.forEach((number, solutionPuzzle) -> {
            StringBuilder rowStringValue1 = generateRowStringValue(null, solutionPuzzle.getTopPuzzlePiece(), null, null);
            StringBuilder rowStringValue2 = generateRowStringValue(solutionPuzzle.getLeftPuzzlePiece(), solutionPuzzle.getFrontPuzzlePiece(), solutionPuzzle.getRightPuzzlePiece(), solutionPuzzle.getBackPuzzlePiece());
            StringBuilder rowStringValue3 = generateRowStringValue(null, solutionPuzzle.getBottomPuzzlePiece(), null, null);
            Path path = Paths.get(directory + "/solution" + counter.getAndIncrement() + ".txt");
            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                writer.write(rowStringValue1.append(rowStringValue2).append(rowStringValue3).toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    /**
     *
     * This method is responsible for create whole text of each row that will place into file (we have 3 rows)
     * colX with value null means there is no puzzle-piece in that column
     *
     * @param col1 : is puzzle-piece data of column1 (nullable)
     * @param col2 : is puzzle-piece data of column1 (nullable)
     * @param col3 : is puzzle-piece data of column1 (nullable)
     * @param col4 : is puzzle-piece data of column1 (nullable)
     * @return
     */
    private StringBuilder generateRowStringValue(PuzzlePiece col1, PuzzlePiece col2, PuzzlePiece col3, PuzzlePiece col4) {
        StringBuilder builder = new StringBuilder();
        int[][] arrayPuzzle1 = col1 != null ? col1.getArrayPuzzle() : null;
        int[][] arrayPuzzle2 = col2 != null ? col2.getArrayPuzzle() : null;
        int[][] arrayPuzzle3 = col3 != null ? col3.getArrayPuzzle() : null;
        int[][] arrayPuzzle4 = col4 != null ? col4.getArrayPuzzle() : null;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 20; j++) {
                if (j < 5) {
                    if (col1 != null) {
                        builder.append(arrayPuzzle1[i][j] == 1 ? "o" : " ");
                    } else {
                        builder.append(" ");
                    }
                } else if (j < 10) {
                    int jj = j - 5;
                    if (col2 != null) {
                        builder.append(arrayPuzzle2[i][jj] == 1 ? "o" : " ");
                    } else {
                        builder.append(" ");
                    }
                } else if (j < 15) {
                    int jj = j - 10;
                    if (col3 != null) {
                        builder.append(arrayPuzzle3[i][jj] == 1 ? "o" : " ");
                    } else {
                        builder.append(" ");
                    }
                } else {
                    int jj = j - 15;
                    if (col4 != null) {
                        builder.append(arrayPuzzle4[i][jj] == 1 ? "o" : " ");
                    } else {
                        builder.append(" ");
                    }
                }
            }
            builder.append("\n");
        }
        return builder;
    }

    /**
     * This method generate all possible cases contains all rotating and mirroring cases of each inputPuzzle
     * and check conditions for each one.
     *
     * //todo this method can be written better - think on that after finish implementation
     *
     * @param puzzle : input puzzle from permutations step
     * @return : return true, if can find any solution, otherwise return flase.
     */
    private boolean checkStatesByOrientations(Puzzle puzzle) {
        for (int top = 0; top < ORIENTATIONS.size(); top++)
            for (int bottom = 0; bottom < ORIENTATIONS.size(); bottom++)
                for (int left = 0; left < ORIENTATIONS.size(); left++)
                    for (int right = 0; right < ORIENTATIONS.size(); right++)
                        for (int back = 0; back < ORIENTATIONS.size(); back++)
                            for (int front = 0; front < ORIENTATIONS.size(); front++) {
                                Puzzle orientationPuzzle = new Puzzle(new PuzzlePiece(puzzle.getTopPuzzlePiece(), ORIENTATIONS.get(top)),
                                        new PuzzlePiece(puzzle.getBottomPuzzlePiece(), ORIENTATIONS.get(bottom)),
                                        new PuzzlePiece(puzzle.getLeftPuzzlePiece(), ORIENTATIONS.get(left)),
                                        new PuzzlePiece(puzzle.getRightPuzzlePiece(), ORIENTATIONS.get(right)),
                                        new PuzzlePiece(puzzle.getBackPuzzlePiece(), ORIENTATIONS.get(back)),
                                        new PuzzlePiece(puzzle.getFrontPuzzlePiece(), ORIENTATIONS.get(front)));
                                if (canMatchConditions(orientationPuzzle)) {
                                    solutions.put(solutions.size(), orientationPuzzle);
                                    logger.debug("Solution : " + orientationPuzzle);
                                    return true;
                                }
                            }
        return false;
    }

    /**
     * This method check all conditions for input puzzle.
     *
     * @param puzzle : input puzzle
     * @return : return true, if can match all conditions, otherwise return flase.
     */
    private boolean canMatchConditions(Puzzle puzzle) {
        //this method is responsible for check some conditions and decide that the current case is solution or not.
        for (Condition condition : CONDITIONS) {
            if (!condition.isMatchCondition(puzzle)) {
                return false;
            }
        }
        return true;
    }
}
