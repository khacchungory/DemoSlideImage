package com.example.demoslideimage.ffmpeg;

@SuppressWarnings("unused")
public interface CommandBuilder {
    CommandBuilder overwriteOutput();
    CommandBuilder inputPath(String inputFilePath);
    CommandBuilder outputPath(String outputPath);
    CommandBuilder trimForDuration(int startPosition, int duration);
    CommandBuilder withoutAudio();
    CommandBuilder copyVideoCodec();
    CommandBuilder crop(int x, int y, int width, int height);
    CommandBuilder customCommand(String customCommand);
    CommandBuilder limitVideoBitrate(String bitrate);
    CommandBuilder experimentalFlag();
    CommandBuilder limitFrameRate(int framerate);
    CommandBuilder fastTune();
    Command build();
}
