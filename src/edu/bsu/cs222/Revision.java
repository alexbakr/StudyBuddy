package edu.bsu.cs222;

public class Revision {
    public static final class Builder {
        private int sleep;
        private int work;
        private int food;
        private int school;
        private int extra;

        private Builder() {}

        public Builder setSleep(int sleep) {
            this.sleep = sleep;
            return this;
        }

        public Builder setWork(int work) {
            this.work = work;
            return this;
        }

        public Builder setFood(int food) {
            this.food = food;
            return this;
        }

        public Builder setSchool(int school) {
            this.school = school;
            return this;
        }

        public Builder setExtra(int extra) {
            this.extra = extra;
            return this;
        }

        public Revision build() { return new Revision(this); }
    }
    public static Builder create() { return new Builder(); }

    public final int sleep;
    public final int work;
    public final int food;
    public final int school;
    public final int extra;

    public Revision(Builder builder) {
        this.sleep = builder.sleep;
        this.work = builder.work;
        this.food = builder.food;
        this.school = builder.school;
        this.extra = builder.extra;
    }
}