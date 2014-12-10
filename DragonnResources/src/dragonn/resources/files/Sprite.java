package dragonn.resources.files;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import dragonn.resources.GVars;

/**
 * Basic resource for sprite-based games. Please note that
 * there is a missingtex.png in dev/res. Removing that and
 * failing to load a texture will immediately crash the
 * program.
 *
 * @author Leo Henri
 * @version V1.0.0B (1/12/2014)
 */
public class Sprite
{
	private BufferedImage	spriteBImg				= null;
	private int				spriteType;
	// SPRITE TYPES:
	// 0 == NULL
	// 1 == SPRITE
	// 2 == SPRITESHEET
	// 3 == ANIMATION
	private int				spriteSW;
	private int				spriteSH;
	private int				frameDelay;
	private int				currentAnim;
	private int				currentFrame;
	private int				frameCount;

	public static final int	SPRITE_TYPE_ERROR		= 0;
	public static final int	SPRITE_TYPE_SPRITE		= 1;
	public static final int	SPRITE_TYPE_SPRITESHEET	= 2;
	public static final int	SPRITE_TYPE_ANIMATION	= 3;

	/**
	 * A basic sprite. Does not allow for any spritesheet or
	 * animation functions
	 *
	 * @param imgPath
	 *            Path to an image, relative to the main
	 *            file path.
	 */
	public Sprite(String imgPath)
	{
		try
		{
			spriteBImg = ImageIO.read(new File(imgPath));
		} catch (IOException e)
		{
			System.out.println("COULD NOT FIND TEXTURE " + imgPath);
			try
			{
				spriteBImg = ImageIO.read(new File("system/missingtex.png"));
			} catch (IOException ex)
			{
				System.out.println("MISSING TEXTURE NOT FOUND: TERMINATING");
				System.exit(1);
			}
		}
		spriteType = 1;
	}

	/**
	 * A spritesheet. Allows the functions of both a sprite
	 * and spritesheet, but does not allow animation
	 * functions.
	 *
	 * @param imgPath
	 *            Path to an image, relative to the main
	 *            file path.
	 * @param spriteWidth
	 *            Width of each subsprite, in pixels.
	 * @param spriteHeight
	 *            Height of each subsprite, in pixels.
	 */
	public Sprite(String imgPath, int spriteWidth, int spriteHeight)
	{
		spriteSW = spriteWidth;
		spriteSH = spriteHeight;

		try
		{
			spriteBImg = ImageIO.read(new File(imgPath));
		} catch (IOException e)
		{
			System.out.println("COULD NOT FIND TEXTURE " + imgPath);
			try
			{
				spriteBImg = ImageIO.read(new File("dbg/res/missingtex.png"));
			} catch (IOException ex)
			{
				System.out.println("MISSING TEXTURE NOT FOUND: TERMINATING");
				System.exit(1);
			}
		}
		spriteType = 2;
	}

	/**
	 * An animation, it allows the use of all functions in
	 * the Sprite object.
	 *
	 * @param imgPath
	 *            Path to an image, relative to the main
	 *            file path.
	 * @param frameWidth
	 *            Width, in pixels, of each frame of the
	 *            animation
	 * @param frameHeight
	 *            Height, in pixels, of each frame of the
	 *            animation
	 * @param frameCount
	 *            Number of frames in the animation.
	 */
	public Sprite(String imgPath, int frameWidth, int frameHeight,
			int frameCount)
	{
		spriteSW = frameWidth;
		spriteSH = frameHeight;
		this.frameCount = frameCount;

		try
		{
			spriteBImg = ImageIO.read(new File(imgPath));
		} catch (IOException e)
		{
			System.out.println("COULD NOT FIND TEXTURE " + imgPath);
			try
			{
				spriteBImg = ImageIO.read(new File("dbg/res/missingtex.png"));
			} catch (IOException ex)
			{
				System.out.println("MISSING TEXTURE NOT FOUND: TERMINATING");
				System.exit(1);
			}
		}
		spriteType = 3;
	}

	/**
	 * An animation, it allows the use of all functions in
	 * the Sprite object.
	 *
	 * @param imgPath
	 *            Path to an image, relative to the main
	 *            file path.
	 * @param frameWidth
	 *            Width, in pixels, of each frame of the
	 *            animation
	 * @param frameHeight
	 *            Height, in pixels, of each frame of the
	 *            animation
	 * @param frameDelay
	 *            Delay, in frames, between the each frame
	 *            of the animation.
	 * @param frameCount
	 *            Number of frames in the animation.
	 * @deprecated
	 */
	public Sprite(String imgPath, int frameWidth, int frameHeight,
			int frameDelay, int frameCount)
	{
		spriteSW = frameWidth;
		spriteSH = frameHeight;
		this.frameCount = frameCount;
		this.frameDelay = frameDelay;

		try
		{
			spriteBImg = ImageIO.read(new File(imgPath));
		} catch (IOException e)
		{
			System.out.println("COULD NOT FIND TEXTURE " + imgPath);
			try
			{
				spriteBImg = ImageIO.read(new File("dbg/res/missingtex.png"));
			} catch (IOException ex)
			{
				System.out.println("MISSING TEXTURE NOT FOUND: TERMINATING");
				System.exit(1);
			}
		}
		spriteType = 3;
	}

	/**
	 * Basic Sprite class.
	 *
	 * @return The BufferedImage that most Sprite classes
	 *         use for their functions.
	 */
	public BufferedImage getImage()
	{
		return spriteBImg;
	}

	/**
	 * Method to get the subimage of this Sprite object's
	 * base image.
	 *
	 * @param x
	 *            The X coordinate of the subimage you want
	 *            to grab.
	 * @param y
	 *            The Y coordinate of the subimage you want
	 *            to grab.
	 * @param length
	 *            The length of the subimage, in pixels.
	 * @param height
	 *            The height of the subimage, in pixels.
	 * @return A BufferedImage of the selected area.
	 */
	public BufferedImage getSubImage(int x, int y, int length, int height)
	{
		BufferedImage tmp = null;

		try
		{
			tmp = spriteBImg.getSubimage(x, y, length, height);
		} catch (Exception e)
		{
			System.out.println("[RES]SPRITE - ERROR GETTING SUBIMAGE: " + x + " 	" + y + " 	"
					+ length + " 	" + height);
		}

		if(GVars.debugEnabled)
		{
			tmp.createGraphics();
			tmp.getGraphics().setColor(Color.white);
			tmp.getGraphics().fillRect(0, 0, 100, 100);
			tmp.getGraphics().setColor(Color.black);
			tmp.getGraphics().setPaintMode();
			tmp.getGraphics().drawString(tmp.getGraphics().getFont().getName(), 0, 0);
			tmp.getGraphics().drawString(Integer.toString(x), 10, 0);
			tmp.getGraphics().drawString(Integer.toString(y), 20, 0);
			tmp.getGraphics().drawString(Integer.toString(length), 30, 0);
			tmp.getGraphics().drawString(Integer.toString(height), 40, 0);
		}

		return tmp;
	}

	/**
	 * Method to get the subimage of this Sprite object's
	 * base image. Used for sprite sheets.
	 *
	 * @param column
	 *            The column that the subimage is located in
	 * @param row
	 *            The row the subimage is located in
	 * @return A BufferedImage of the selected subsprite if
	 *         a spritesheet or animation. Null otherwise
	 */
	public BufferedImage getSubImage(int column, int row)
	{
		if (spriteType >= SPRITE_TYPE_SPRITESHEET)
		{
			return getSubImage(column * spriteSW + 1, row * spriteSH,
					spriteSW - 1, spriteSH);
		}
		else
		{
			return null;
		}
	}

	/**
	 * Get the next frame of the current animation. This
	 * automatically advances the frame count.
	 *
	 * @return BufferedImage of the next animation frame if
	 *         it is an animation. Returns null otherwise.
	 */
	public BufferedImage getNextFrame()
	{
		if (spriteType <= SPRITE_TYPE_ANIMATION)
		{
			currentFrame++;
			if (currentFrame >= frameCount)
			{
				currentFrame = 0;
			}
			return getSubImage(currentAnim, currentFrame);
		}
		else
		{
			return null;
		}
	}

	/**
	 * Get the next frame of the selected animation
	 * variation. This automatically advances the frame
	 * count. This does not set the current animation.
	 *
	 * @param animVariation
	 * @return BufferedImage of the next animation frame if
	 *         it is animation. Returns null otherwise.
	 */
	public BufferedImage getNextFrame(int animVariation)
	{
		if (spriteType >= SPRITE_TYPE_ANIMATION)
		{
			currentFrame++;
			if (currentFrame >= frameCount)
			{
				currentFrame = 0;
			}
			return getSubImage(animVariation, currentFrame);
		}
		else
		{
			return null;
		}
	}

	/**
	 * Get the current frame of the current animation. This
	 * does not automatically advance the frame count.
	 *
	 * @return BufferedImage of the current animation frame
	 *         if it is an animation. Returns null
	 *         otherwise.
	 */
	public BufferedImage getCurrentFrame()
	{
		if (spriteType >= SPRITE_TYPE_ANIMATION)
		{
			return getSubImage(currentAnim, currentFrame);
		}
		else
		{
			return null;
		}
	}

	/**
	 * Get the current frame of the selected animation
	 * variation. This does not automatically advance the
	 * frame count. This does not set the current animation.
	 *
	 * @param animVariation
	 * @return The current frame of the selected animation
	 *         variation, if it is an animation. Returns
	 *         null otherwise.
	 */
	public BufferedImage getCurrentFrame(int animVariation)
	{
		if (spriteType >= SPRITE_TYPE_ANIMATION)
		{
			return getSubImage(animVariation, currentFrame);
		}
		else
		{
			return null;
		}
	}

	/**
	 * Reset the animation state. Has no effect on the image
	 * unless it is a running animation.
	 */
	public void resetAnimation()
	{
		currentFrame = 0;
		currentAnim = 0;
	}

	/**
	 * Set the animation state. Has no effect unless it is
	 * an running animation.
	 *
	 * @param frame
	 *            Set the animation frame.
	 * @param variation
	 *            Set the animation variation.
	 */
	public void setAnimation(int frame, int variation)
	{
		currentFrame = frame;
		currentAnim = variation;
	}

	/**
	 * Get the current frame that the animation is on.
	 *
	 * @return Integer value of the current frame number.
	 */
	public int currentFrame()
	{
		return currentFrame;
	}

	/**
	 * Get the current animation that is playing
	 *
	 * @return Integer value of the current animation
	 *         variation.
	 */
	public int currentAnim()
	{
		return currentAnim;
	}
}
