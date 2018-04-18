package dsaMagicTouch;

public enum EnumSprite {
	WIDTH(985),
	HEIGHT(720);

    private final int value;

    EnumSprite(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }

}
