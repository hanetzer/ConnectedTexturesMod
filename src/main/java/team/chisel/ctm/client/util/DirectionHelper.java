package team.chisel.ctm.client.util;

import static net.minecraft.util.Direction.*;

import net.minecraft.util.Direction;

/**
 * A bunch of methods that got stripped out of Direction in 1.15
 * 
 * @author Mojang
 */
public class DirectionHelper {

	public static Direction rotateAround(Direction dir, Direction.Axis axis) {
		switch (axis) {
		case X:
			if (dir != WEST && dir != EAST) {
				return rotateX(dir);
			}

			return dir;
		case Y:
			if (dir != UP && dir != DOWN) {
				return dir.rotateY();
			}

			return dir;
		case Z:
			if (dir != NORTH && dir != SOUTH) {
				return rotateZ(dir);
			}

			return dir;
		default:
			throw new IllegalStateException("Unable to get CW facing for axis " + axis);
		}
	}

	public static Direction rotateX(Direction dir) {
		switch (dir) {
		case NORTH:
			return DOWN;
		case EAST:
		case WEST:
		default:
			throw new IllegalStateException("Unable to get X-rotated facing of " + dir);
		case SOUTH:
			return UP;
		case UP:
			return NORTH;
		case DOWN:
			return SOUTH;
		}
	}

	public static Direction rotateZ(Direction dir) {
		switch (dir) {
		case EAST:
			return DOWN;
		case SOUTH:
		default:
			throw new IllegalStateException("Unable to get Z-rotated facing of " + dir);
		case WEST:
			return UP;
		case UP:
			return EAST;
		case DOWN:
			return WEST;
		}
	}
}