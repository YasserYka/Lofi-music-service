

const audioContexr = new AudioContext();

let audio;

fetch('./songs/Antidepresseur.mp3')
    .then(data => data.arrayBuffer())
    .then(buffer => audioContexr.decodeAudioData(buffer))
    .then(decodeAudio => {
        audio = decodeAudio;
    });

function play(){
    const playSound = audioContexr.createBufferSource();
    playSound.buffer = audio;
    playSound.connect(audioContexr.destination);
    playSound.start(audioContexr.currentTime);
};

window.addEventListener("mousedown", play);

