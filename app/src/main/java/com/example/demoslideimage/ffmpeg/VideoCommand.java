package com.example.demoslideimage.ffmpeg;

import java.io.File;
import java.util.List;

class VideoCommand implements Command {
    private static final String FFMPEG_PROGRAM_NAME = "ffmpeg";

    private final List<String> arguments;
    private final String outputPath;
    private final MyFFmpeg myFFmpeg;

    VideoCommand(List<String> flags, String outputPath, MyFFmpeg myFFmpeg) {
        this.arguments = flags;
        this.outputPath = outputPath;
        this.myFFmpeg = myFFmpeg;

    }

    @Override
    public VideoProcessingResult execute() {
        final int returnCode = myFFmpeg.process(getArgumentsAsArray());
        if (returnCode == VideoProcessingResult.SUCCESSFUL_RESULT) {
            return new VideoProcessingResult(returnCode, outputPath);
        } else {
            deleteOutput();
            return new VideoProcessingResult(returnCode, null);
        }
    }

    private String[] getArgumentsAsArray() {
        final String ffmpegArguments[] = new String[arguments.size() + 1];
        for (int i = 0; i < arguments.size(); i++) {
            ffmpegArguments[i + 1] = arguments.get(i);
        }

        ffmpegArguments[0] = FFMPEG_PROGRAM_NAME;

        return ffmpegArguments;
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private void deleteOutput() {
        final File output = new File(outputPath);
        if (output.exists()) {
            output.delete();
        }
    }
}