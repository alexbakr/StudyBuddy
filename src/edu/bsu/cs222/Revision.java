package edu.bsu.cs222;

public class Revision {
    public static final class Builder {
        private int sleep;
        private int work;

        private Builder() {}

        public Builder setSleep(int sleep) {
            this.sleep = sleep;
            return this;
        }

        public Builder setWork(int work) {
            this.work = work;
            return this;
        }

        public Revision build() { return new Revision(this); }
    }
    public static Builder create() { return new Builder(); }

    public final int sleep;
    public final int work;

    public Revision(Builder builder) {
        this.sleep = builder.sleep;
        this.work = builder.work;
    }
}